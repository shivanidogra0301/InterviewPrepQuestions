package Arrays.TwoPointerApproach;
class LongPressedQues{
    public boolean isLongPressedName(String name, String typed) {
    
        int i = 0,j = 0;
        while(i < name.length() && j < typed.length()){
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);
            
            if(ch1 == ch2){
                i++;
                j++;
            }
            else{
                if(j == 0){
                    return false;
                }
                else {
                    char prev = typed.charAt(j-1);
                    if(prev == ch2){
                        j++;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(i < name.length()){
            return false;
        }
        while( j < typed.length()){
            char prev = typed.charAt(j-1);
            char cur = typed.charAt(j);
            if(prev == cur){
                j++;
            }
            else{
                return false;
            }
        }
    
            return true;
    }
}