import java.sql.SQLOutput;
import java.util.ArrayList;

class Node<K,V>
{
    int hashcode;
    K Key;
    V Value;
    Node next;

    public Node(K key, V value) {
        Key = key;
        Value = value;
        next=null;
    }
}

public class HashMapImplementation<K,V> {

    static int SIZE=16;
    Node arr[]= new Node[SIZE];
    public void put(K key, V value)
    {
        int hashcode= String.valueOf(key).hashCode()%SIZE;
        Node newNode=new Node(key,value);
        if(arr[hashcode]==null)
        {
            newNode.hashcode=hashcode;
            arr[hashcode]=newNode;
        }
        else {
            Node temp = arr[hashcode];
            if(temp.Key.equals(newNode.Key))
            {
                temp.Value=value;
                return;
            }
            while (temp.next != null) {
                if(temp.Key.equals(newNode.Key))
                {
                    temp.Value=value;
                    return;
                }
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void get(K key)
    {
        int hashcode= String.valueOf(key).hashCode()%SIZE;
        if(arr[hashcode]==null)
        {
            System.out.println("Value doesnot exist");
        }
        else
        {
            Node temp=arr[hashcode];
            while(temp!=null)
            {
                if(temp.Key.equals(key))
                {
                    System.out.println(temp.Value+"----------");
                    return;
                }
                temp=temp.next;

            }
            System.out.println("This value doesnot exist");
        }
    }

    public static void main(String[] args) {

        HashMapImplementation<String,String> hm= new HashMapImplementation<String, String>();
        hm.put("abac","1");
        hm.put("abbc","2");
        hm.put("abac","3");
        hm.get("abac");
        hm.get("wefh");

    }
}
