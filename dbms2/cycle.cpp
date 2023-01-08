#include<bits/stdc++.h>
using namespace std;

int main(){
    int originx=0;
    int countx=0;
    int county=0;
    int originy=0;
    int flag=0;
    string r;
    int n;
    freopen("dir.txt", "r", stdin);
    cin>>n;
    while(n--){
      
    cin>>r;
    if(r.find('x') !=std::string::npos)
    {   
        if(countx==0)
        {
         originx= int(r[1])-48 ; 
         
         countx++;
        }
        else{
            if (int(r[1])-48 == originx)
            {
                cout<<"there is loop for x"<<"\n"<<"conflict not serializable";
                flag=1;
                break;
            }
        }
        
    }
    if(r.find('y') !=std::string::npos)
    {   
        if(county==0)
        {
         originy= int(r[1])-38 ; 
        
         county++;
        }
        else{
            if (int(r[1])-38 == originy)
            {
                cout<<"there is loop for y"<<"\n"<<"conflict not serializable";
                flag=1;
                break;
            }
        }
        
    }
    
    }
   
   
    
    
    if(flag==0)
    {
        cout<<"there is no loop. conflict serializable";
    }
    
}
    
    
        
