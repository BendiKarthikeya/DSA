 #include<stdio.h>
 int main(){
   int a,b,m;
   scanf("%d %d %d",&a,&b,&m);
   int x=power(a,b)%m;
   printf("%d",x);
 }
 int power(int a,int b){
   if(b==0){
     return 1;
   }
   return a*power(a,b-1);
 }