class Node:
    def __init__(self,data,prev=None,next=None):
        self.data=data
        self.prev=prev
        self.next=next
    
    def __str__(self):
        return str(self.data)
    
class DLL:
    def __init__(self):
        self.__head=None
        self.__tail=None
        self.__size=0

    def size(self):
        return self.__size
    
    def isEmpty(self):
        return self.size()==0

    def append(self,data):
        newNode=Node(data)
        if self.isEmpty():
            self.__head=newNode
            self.__tail=newNode
        else:
            self.__tail.next=newNode
            newNode.prev=self.__tail
            self.__tail=newNode
        self.__size+=1
    
    def __str__(self):
        l=[]
        trav=self.__head
        while trav is not None:
            l.append(trav.data)
            trav=trav.next
        return "<---->".join(map(str,l))
    
    def addFirst(self,data):
        newNode=Node(data)
        if self.isEmpty():
            self.__head=newNode
            self.__tail=newNode
        else:
            newNode.next=self.__head
            self.__head.prev=newNode
            self.__head=newNode
        self.__size+=1

    def addAt(self,index,data):
        if 0>index or index>self.size():
            raise Exception("Invalid Index")
        if index==0:
            self.addFirst(data)
        elif index==self.size():
            self.append(data)
        else:
            id=0
            trav=self.__head

            while id!=index-1:
                id+=1
                trav=trav.next
            
            newNode=Node(data,trav,trav.next)
            trav.next=newNode
            newNode.next.prev=newNode
        
    def heads(self):
        return self.__head
    
    def removeFirst(self):
        temp=self.__head
        self.__head=self.__head.next
        self.__head.prev=None
        del temp
        self.__size-=1

    def removeLast(self):
        temp=self.__tail
        self.__tail=self.__tail.prev
        self.__tail.next=None
        del temp
        self.__size-=1
    def removeAt(self,index):
        i=0
        trav=self.__head
        while i!=index-1:
            i+=1
            trav=trav.next
        temp=trav.next
        trav.next=trav.next.next
        trav.next.prev=trav
        del temp
    
# contains(elements)
# indexof(elements)       
l=DLL()
l.append(5)
l.append(6)
l.addFirst(1)
print(l.__str__())
print(l.heads())
