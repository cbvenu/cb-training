package bookstore;
import java.util.*;
import java.lang.*;
class Book 
{
 private String name;
 private Author[] authors;
 private double price;
 private int qst=0;

 Book(String name,Author[] a,double price, int qst)
{
this.name=new String(name);
authors=new Author[a.length];
for(int i=0;i<a.length;i++)
{
authors[i]=new Author(a[i].getName(),a[i].getEmail(),a[i].getGender());
//authors[i]=a[i];
}
this.qst=qst;
this.price=price;
}

Book(String name,Author a,double price,int qst)
{
this.name=name;
authors=new Author[1];
authors[0]=new Author(a.getName(),a.getEmail(),a.getGender());
//auhtors=a;
this.price=price;
this.qst=qst;
}

public String getName()
{
return name;
}

public Author[] getAuthors()
{
return authors;
}
public double getPrice()
{
return price;
}
public void setPrice(double price)
{
this.price=price;
}
public int getQuantity()
{
return qst;
}
public void setQuantity(int q)
{
qst=q;
}

public String toDisplay()
{
int i=0;
String res=new String(name);
res=res+" by";
for(i=0;i<authors.length;i++)
{
 res=res+" "+authors[i].toDisplay();
}
res=res+" Price:"+price+"\n No of books Available:"+qst;
return res;
}

public void printAuthors()
{
int i;
System.out.println("Author details for the book "+name);
for(i=0;i<authors.length;i++)
{
System.out.println(authors[i].toDisplay());
}
}

public void addAuthor(Author a)
{
authors[authors.length]=new Author(a.getName(),a.getEmail(),a.getGender());
}

public static void main(String[] args)
{
     Author a=new Author("Venu","venu@abc.com",'M');
 Book b=new Book("Java Programming",a,200,10);
System.out.println(b.toDisplay());
Author c=new Author("VG","vg1234@gmail.com",'M');
b.addAuthor(c);
System.out.println("\n\n"+b.toDisplay());
}
}
