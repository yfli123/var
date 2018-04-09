package com.yfli.test.algorithm;

public class BinaryTree {  
    private BNode root; //���ڵ�  
      
    public BinaryTree() {  
        root = null;  
    }  
      
    //�������������ҵ�ʱ�临�Ӷ�ΪO(logN)  
    public BNode find(int key) { //find node with given key  
        BNode current = root;  
        while(current.key != key) {  
            if(key < current.key) {  
                current = current.leftChild;  
            }  
            else {  
                current = current.rightChild;  
            }  
            if(current == null) {  
                return null;  
            }  
        }  
        return current;  
    }  
      
    //����ڵ�  
    public void insert(int key, double value) {  
        BNode newNode = new BNode();  
        newNode.key = key;  
        newNode.data = value;  
        if(root == null) { //if tree is null  
            root = newNode;  
        }  
        else {  
            BNode current = root;  
            BNode parent;  
            while(true) {  
                parent = current;  
                if(key < current.data) { //turn left  
                    current = current.leftChild;  
                    if(current == null) {  
                        parent.leftChild = newNode;  
                        newNode.parent = parent;  
                        return;  
                    }  
                }  
                else { //turn right  
                    current = current.rightChild;  
                    if(current == null) {  
                        parent.rightChild = newNode;  
                        newNode.parent = parent;  
                        return;  
                    }  
                }  
            }  
        }  
    }  
      
    //����������  
    public void traverse(int traverseType) {  
        switch(traverseType)  
        {  
        case 1: System.out.println("Preorder traversal:");  
                preOrder(root);//ǰ�����  
                break;  
        case 2: System.out.println("Inorder traversal:");  
                inOrder(root);//�������  
                break;  
        case 3: System.out.println("Postorder traversal:");  
                postOrder(root);//�������  
                break;  
        default: System.out.println("Inorder traversal:");  
                inOrder(root);  
                break;  
        }  
        System.out.println("");  
    }  
      
    //ǰ�����  
    private void preOrder(BNode localRoot) {  
        if(localRoot != null) {  
            System.out.print(localRoot.data + " ");  
            preOrder(localRoot.leftChild);  
            preOrder(localRoot.rightChild);  
        }  
    }  
      
    //�������  
    private void inOrder(BNode localRoot) {  
        if(localRoot != null) {  
            inOrder(localRoot.leftChild);  
            System.out.print(localRoot.data + " ");  
            inOrder(localRoot.rightChild);  
        }  
    }  
      
    //�������  
    private void postOrder(BNode localRoot) {  
        if(localRoot != null) {  
            postOrder(localRoot.leftChild);  
            postOrder(localRoot.rightChild);  
            System.out.print(localRoot.data + " ");  
        }  
    }  
      
    //������Сֵ  
    /*���ݶ����������Ĵ洢������СֵӦ��������Ǹ�û���ӽڵ���Ǹ��ڵ�*/  
    public BNode minNumber() {  
        BNode current = root;  
        BNode parent = root;  
        while(current != null) {  
            parent = current;  
            current = current.leftChild;  
        }     
        return parent;  
    }  
      
    //�������ֵ  
    /*���ݶ����������Ĵ洢�������ֵӦ�����ұ��Ǹ�û���ӽڵ���Ǹ��ڵ�*/  
    public BNode maxNumber() {  
        BNode current = root;  
        BNode parent = root;  
        while(current != null) {  
            parent = current;  
            current = current.rightChild;  
        }     
        return parent;  
    }  
      
    //ɾ���ڵ�  
    /* 
     * ɾ���ڵ��ڶ�����������ӵģ���Ҫ����������� 
     * 1. �ýڵ�û���ӽڵ㣨�򵥣� 
     * 2. �ýڵ���һ���ӽڵ㣨���У� 
     * 3. �ýڵ��������ӽڵ㣨���ӣ� 
     * ɾ���ڵ��ʱ�临�Ӷ�ΪO(logN) 
     */  
    public boolean delete(int key) {  
        BNode current = root;  
//      BNode parent = root;  
        boolean isLeftChild = true;  
          
        if(current == null) {  
            return false;  
        }  
        //Ѱ��Ҫɾ���Ľڵ�  
        while(current.data != key) {  
//          parent = current;  
            if(key < current.key) {  
                isLeftChild = true;  
                current = current.leftChild;  
            }  
            else {  
                isLeftChild = false;  
                current = current.rightChild;  
            }  
            if(current == null) {  
                return false;  
            }  
        }  
          
        //�ҵ���Ҫɾ���Ľڵ㣬���濪ʼɾ��  
        //1. Ҫɾ���Ľڵ�û���ӽڵ�,ֱ�ӽ��丸�ڵ�����ӽڵ�������ӽڵ㸳Ϊnull����  
        if(current.leftChild == null && current.rightChild == null) {  
            return deleteNoChild(current, isLeftChild);  
        }  
          
        //3. Ҫɾ���Ľڵ��������ӽڵ�  
        else if(current.leftChild != null && current.rightChild != null) {  
            return deleteTwoChild(current, isLeftChild);  
        }  
          
        //2. Ҫɾ���Ľڵ���һ���ӽڵ㣬ֱ�ӽ��俳�ϣ������ӽڵ����丸�ڵ����������ɣ�Ҫ���������������ɾ�����ڵ㣬��Ϊ���ڵ�û�и��ڵ�  
        else {  
            return deleteOneChild(current, isLeftChild);  
        }  
          
    }  
      
    public boolean deleteNoChild(BNode node, boolean isLeftChild) {  
        if(node == root) {  
            root = null;  
            return true;  
        }  
        if(isLeftChild) {  
            node.parent.leftChild = null;  
        }  
        else {  
            node.parent.rightChild = null;  
        }  
        return true;  
    }  
      
    public boolean deleteOneChild(BNode node, boolean isLeftChild) {  
        if(node.leftChild == null) {  
            if(node == root) {  
                root = node.rightChild;  
                node.parent = null;  
                return true;  
            }  
            if(isLeftChild) {  
                node.parent.leftChild  = node.rightChild;  
            }  
            else {  
                node.parent.rightChild = node.rightChild;  
            }  
            node.rightChild.parent = node.parent;  
        }  
        else {  
            if(node == root) {  
                root = node.leftChild;  
                node.parent = null;  
                return true;  
            }  
            if(isLeftChild) {  
                node.parent.leftChild  = node.leftChild;  
            }  
            else {  
                node.parent.rightChild = node.leftChild;  
            }  
            node.leftChild.parent = node.parent;  
        }  
        return true;  
    }  
      
    public boolean deleteTwoChild(BNode node, boolean isLeftChild) {  
        BNode successor = getSuccessor(node);  
        if(node == root) {  
            successor.leftChild = root.leftChild;  
            successor.rightChild = root.rightChild;  
            successor.parent = null;  
            root = successor;  
        }  
        else if(isLeftChild) {  
            node.parent.leftChild = successor;  
        }  
        else {  
            node.parent.rightChild = successor;  
        }  
        successor.leftChild = node.leftChild;//connect successor to node's left child  
        return true;  
    }  
      
    //���Ҫɾ���ڵ�ĺ�̽ڵ㣨�����������һ���ڵ㣩  
    public BNode getSuccessor(BNode delNode) {  
        BNode successor = delNode;  
        BNode current = delNode.rightChild;  
        while(current != null) {  
            successor = current;  
            current = current.leftChild;  
        }  
        if(successor != delNode.rightChild) {  
            successor.parent.leftChild = successor.rightChild;  
            if(successor.rightChild != null) {        
                successor.rightChild.parent = successor.parent;//ɾ�������ڵ���ԭ����λ��  
            }  
            successor.rightChild = delNode.rightChild;//�������ڵ�ŵ���ȷλ�ã����ұ�����  
        }  
        return successor;  
    }  
}  
  
class BNode {  
    public int key;  
    public double data;  
    public BNode parent;  
    public BNode leftChild;  
    public BNode rightChild;  
      
    public void displayNode() {  
        System.out.println("{" + key + ":" + data + "}");  
    }  
} 