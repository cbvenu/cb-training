package bookstore;

import java.util.*;
import java.lang.*;

class Author
{
 private String name,email;
 private char gender;

 Author(String name,String email,char gender)
  {
  this.name=new String(name);
  this.email=new String(email);
  this.gender=gender;
  }

 public String getName()
  {
  return name;
  }
  
 public String getEmail()
  {
  return email;
  }
 
 public void setEmail(String e)
  {
  email=e;
  }
 
 public char getGender()
  {
  return gender;
  }

 public String toDisplay()
  {
  String res=new String();
  res=name+" "+gender+ " at " +email;
  return res;
  }
 

public static void main(String[] args)
{
Author r=new Author("R.K. Narayan","rknarayan@gmail.com",'M');
System.out.println(r.toDisplay());
r.setEmail("changed@gmail.com");
System.out.println(r.toDisplay());
}

}
