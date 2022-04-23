import java.lang.StringBuilder;

class Problem2
{
     private static final class ListNode 
     {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
         public String toString()
         {
            final StringBuilder sb = new StringBuilder();
            ListNode ln = this;
            while( ln != null )
            {
                sb.append(ln.val);
                ln = ln.next;
            }

            return sb.toString();
         } 
     }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode sum = null;
        ListNode output = null;
        boolean carry = false;
        while (l1 != null || l2 != null)
        {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if(carry)
            {
                val++;
                carry = false;
            }

            if (val > 9)
            {
                carry = true;
                val = val % 10;
            }
            
            if (output == null)
            {
                output = new ListNode(val);
                sum = output;
            }
            else
            {
                sum.next = new ListNode(val);
                sum = sum.next;
            }
            
            // advance the decimal place of both inputs 
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry)
            sum.next = new ListNode(1);
        return output;
     }
  

     private static ListNode build(int number)
     {
        ListNode output = null;
        ListNode builder = null;
        while (number > 0)
        {
            int digit = number % 10;
            number = number / 10;
            
            if (builder == null)
            {
                builder = new ListNode(digit);
                output = builder;
            }
            else 
            {
                builder.next = new ListNode(digit);
                builder = builder.next;
            }
        }
        return output;
     }


     public static void main(String[] args)
     {
        final ListNode l1 = build(342);
        final ListNode l2 = build(465);

        System.out.println(l1 + "\n" + l2 + "\n" + addTwoNumbers(l1,l2) );
     }

}
