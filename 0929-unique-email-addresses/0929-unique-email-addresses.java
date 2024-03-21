
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            StringBuilder modifiedEmail = new StringBuilder();
            boolean ignore = false;
            boolean domain = false;
            
            for (char ch : email.toCharArray()) {
                if (ch == '@') {
                    ignore = false;
                    domain = true;
                }
                
                if (!domain) {
                    if (ch == '.') {
                        continue;
                    } else if (ch == '+') {
                        ignore = true;
                        continue;
                    }
                }
                
                if (!ignore) {
                    modifiedEmail.append(ch);
                }
            }
            
            uniqueEmails.add(modifiedEmail.toString());
        }
        
        return uniqueEmails.size();
    }
}
