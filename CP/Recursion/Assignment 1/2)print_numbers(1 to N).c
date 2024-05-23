#include<stdio.h>
void Number(int n){
		if(n>1){
			Number(n-1);
			
		}
		printf("%d ",n);
		}
int main(){
	int n;
	scanf("%d",&n);
	Number(n);
	return 0;
	}
