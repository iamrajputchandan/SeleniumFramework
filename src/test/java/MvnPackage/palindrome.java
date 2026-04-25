package MvnPackage;

public class palindrome {
	
	boolean ispalindrome(int n) {
		int rev =0;
		int temp=n;
		while(temp!=0) {
			int ld = temp%10;
			rev = rev*10+ld;
			temp=temp/10;
			
		}
		return (rev==n);
		
	}

	  public static void main(String[] args) {
		  palindrome p = new palindrome();
	        if(p.ispalindrome(78987)) {
	        	System.out.println("The number is palindrome");
	        }
	        else {
	        	System.out.println("The number is not palindrome");
	        }
	    }
	}

