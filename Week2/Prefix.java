import java.util.*;
class Prefix
{
public static String longest(String[] strings) {
    if (strings.length == 0) {
        return "";   // Or maybe return null?
    }

    for (int prefixLen = 0; prefixLen < strings[0].length(); prefixLen++)
    {
    char c = strings[0].charAt(prefixLen);
    for (int i = 1; i < strings.length; i++) {
   if(prefixLen >= strings[i].length() || strings[i].charAt(prefixLen) != c )
    {
                // Mismatch found
                return strings[i].substring(0, prefixLen);
            }
        }
    }
    return strings[0];
}
public static void main(String[] args)
{
 String[] s=new String[3];
 s[0]=new String("venu");
 s[1]=new String("venue");
 s[2]=new String("venugopal");
 System.out.println("OUtput"+longest(s));
}
}
