class Solution {
public:
    
    struct Times {
        int processingTime;
        int enqueueTime;
        int index;
    };
    
    struct compareProcessingTime {
        bool operator()(Times const& t1, Times const& t2) {
            if (t1.processingTime == t2.processingTime) {
                return t1.index > t2.index;
            }
            return t1.processingTime > t2.processingTime;
        }
    };
    
    struct compareEnqueueTime {
        bool operator()(Times const& t1, Times const& t2) {
            if (t1.enqueueTime == t2.enqueueTime) {
                return t1.index > t2.index;
            }
            return t1.enqueueTime >= t2.enqueueTime;
        }
    };
    
    vector<int> getOrder(vector<vector<int>>& tasks) {
        priority_queue<Times, vector<Times>, compareEnqueueTime> enqueueQueue;
        priority_queue<Times, vector<Times>, compareProcessingTime> processingQueue;
        vector<int> ans; 
        
        int len = tasks.size();
        int ind = 0;
        for (int i = 0; i < len; i++) {
            Times time;
            time.processingTime = tasks[i][1];
            time.enqueueTime = tasks[i][0];
            time.index = i;
            enqueueQueue.push(time);
        }
        
        int timePassed = enqueueQueue.top().enqueueTime;
        while(!enqueueQueue.empty()) {
            Times time1 = enqueueQueue.top();
            if (time1.enqueueTime <= timePassed) {
                processingQueue.push(time1);
                enqueueQueue.pop();
            } else {
                while(!processingQueue.empty()) {
                    Times time2 = processingQueue.top();
                    ans.push_back(time2.index);
                    processingQueue.pop();
                    timePassed+=time2.processingTime;
                    if (time1.enqueueTime <= timePassed) {
                        processingQueue.push(time1);
                        enqueueQueue.pop();
                        break;
                    } else if (processingQueue.empty()) {
                        timePassed = enqueueQueue.top().enqueueTime;
                        processingQueue.push(time1);
                        enqueueQueue.pop();
                        break;
                    }
                }
            }
        }
        
        while(!processingQueue.empty()) {
            Times time2 = processingQueue.top();
            ans.push_back(time2.index);
            processingQueue.pop();
        }
        
        return ans;
    }
};