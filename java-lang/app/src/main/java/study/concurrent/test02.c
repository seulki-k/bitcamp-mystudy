#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
    
    int i ;
    pid_t processId;
    
    for(i =0; i<100; i++){
    printf("==> %d\n",i);    
    }
    printf("-----------------------------------\n");
    
    processId = fork(); // 프로세스 복제
    
    for(i =0; i<100; i++){
    printf("[%d]~~~~~~~~~~~~~~~~~~~~~> %d\n",processId,i);    
    }
    
    return 0;
}