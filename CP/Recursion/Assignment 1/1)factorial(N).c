#include<stdio.h>
int fact(int n){
	if(n<=1){
	 	return 1;
	 	}
	return n*fact(n-1);
}

int main(){
	int n;
	scanf("%d",&n);
	if(n>=0){
	int x=fact(n);
	printf("%d",x);
}
else{
	printf("It is a negative number");
}
}
