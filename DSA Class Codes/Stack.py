class Node:
    def __init__(self,data=None,next=None) -> None:
        self.data=data
        self.next=next
    
class Stack:
    def __init__(self):
        self.sz=0
        self.head=None
    
    def size(self):
        return self.sz
    
    def isEmpty(self):
        return self.size()==0
    
    def push(self,element) :
        newNode=Node(element,self.head)
        self.head=newNode
        self.sz+=1

    def pop(self):
        if self.isEmpty(self):
            raise Exception("Stack Underflow")
        temp=self.head
        data=temp.data
        self.head=self.head.next
        del temp
        return data

    def __str__(self) -> str:
        ele=[]

        trav=self.head
    