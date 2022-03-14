class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        vector<int> adj[n];
        map<pair<int, int>, bool> mp;
        
        for (auto it: connections) {
            mp[{it[0], it[1]}] = true;
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }
        
        queue<int> q;
        q.push(0);
        vector<bool> vis(n);
        vis[0] = true;
        int ans = 0;
        while(!q.empty()) {
            int parent = q.front();
            q.pop();
            for (auto child: adj[parent]) {
                if (!vis[child]) {
                    if (mp.find({child, parent}) == mp.end())
                        ans++;
                    vis[child] = true;
                    q.push(child);   
                }
            }
        }
        
        return ans;
    }
};