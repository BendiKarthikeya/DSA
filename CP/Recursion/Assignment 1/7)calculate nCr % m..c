#include<stdio.h>
int fact(int n){
	if(n<=1){
	 	return 1;
	 	}
	return n*fact(n-1);
}

int main(){
	int n,r,m;
	scanf("%d %d %d",&n,&r,&m);
	if(n>=0){
	int x=fact(n)/(fact(n-r)*fact(r));
	int y=x%m;
	printf("%d",y);
}
else{
	printf("It is a negative number");
}
}
