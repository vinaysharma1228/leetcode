
class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (!component.isEmpty()) {
                if (component.equals(".")) {
                    // Do nothing (current directory)
                } else if (component.equals("..")) {
                    // Move up one level (if possible)
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    // Valid directory, push onto stack
                    stack.push(component);
                }
            }
        }

        // Construct the simplified canonical path
        StringBuilder result = new StringBuilder("/");
        for (String dir : stack) {
            result.append(dir).append("/");
        }

        // Remove the trailing slash if present
        if (result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
