#include<bits/stdc++.h>
using namespace std;

bool subset(string s, string t) {
    int i = 0;
    int j = 0;
    while (i < s.size() && j < t.size()) {
        if (s[i] == t[j]) {
            i++;
            j++;
        } else {
            i++;
        }
    }
    return j == t.size();
}

int main() {
    string s, t;
    cin >> s >> t;
    if (subset(s, t)) {
        cout << "Yes, " << t << " is a subset of " << s << endl;
    } else {
        cout << "No, " << t << " is not a subset of " << s << endl;
    }
    return 0;
}


// #include<bits/stdc++.h>
// using namespace std;
// int main(){
// str s,t;
// cin >> s >> t;
// }
// subset(s,t){
// int i=0;
// int j=0;
// while(i<len(s) && j<len(t)){
//     if(s[i]==t[j]){
//         i=i+1;
//         j=j+1;
//     }
//     else  i=i+1;
// if(j==len(t)) return True;
// else return False;
// }
// }
