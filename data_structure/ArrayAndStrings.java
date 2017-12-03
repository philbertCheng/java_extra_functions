class ArrayAndStrings{
    
    public static boolean isCharUnique(String s){
        //tell you if all the character in the string is unique
        //compare each character to char behind it
        for(int i = 0 ; i < s.length() ; i++){
            char cur = s.charAt(i);
            String sub = s.substring(i+1, s.length());
            for(int j = 0 ; j < sub.length(); j++){
                if(cur == sub.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCharUniqueUsingList(String s){
        //tell if all the charcter in the string is unique
        //using a list to store if we have seen the corresponding ASCII char
        boolean[] seen = new boolean[256];
        for(int i = 0 ; i < s.length(); i++){
            char cur = s.charAt(i);
            if(seen[cur]){
                return false;
            }
            seen[cur] = true;
        }
        return true;
    }
    

    public static boolean isPermutation(String s1, String s2){
        //check if one string is permutation of another
        if(s1.length() != s2.length()){
            return false;    
        }
        int[] letters = new int[256];
        char[] s1_array = s1.toCharArray();
        for(char l :  s1_array){
            letters[l]++;
        }
        for(int i = 0; i < s2.length(); i++){
            char cur = s2.charAt(i);
            if(--letters[cur] < 0){
                return false;
            }
        }
        return true;
    }

    public static String sort(String s){
        //return sorted string
        char[] array_s = s.toCharArray();
        java.util.Arrays.sort(array_s);
        return(new String(array_s));
    }

    public static char[] replaceSpace(char[] s, int trueLength){
        //replace spaces with %20 and delete all ending extra string
        int spaces = 0;
        for(int i = 0 ; i < trueLength ; i++){
            if(s[i] == ' '){
                spaces++;
            }
        }
        int newLength = trueLength + 2*spaces;

        for(int j = trueLength - 1 ; j >= 0 ; j-- ){
            if(s[j] == ' '){
                s[newLength -1] = '0';
                s[newLength -2] = '2';
                s[newLength -3] = '%';
                newLength -= 3;

            }else{
                s[newLength - 1] = s[j];
                newLength --; 
            }
        }
        return s;
    }

    public static String compress(String s){
        //return compressed string
        char cur = s.charAt(0);
        int consecutive = 1;
        String result = "";
        for(int i = 1 ; i < s.length(); i ++){
                if(s.charAt(i) != cur){
                    result += cur;
                    result += consecutive;
                    cur = s.charAt(i);
                    consecutive = 1;
                }else{
                    consecutive ++;
                }
        }
        result += cur;
        result += consecutive;
        return (result.length() >= s.length()) ?  s : result;
    }

    public static int[][] rotateMatrix(int[][] original){
        int[][] newm = new int[original.length][original.length];
        for(int i = 0 ; i < original.length ; i ++){
            for(int j = 0 ; j < original.length; j ++){
                newm[j][original.length-1-i] = original[i][j] ;
            
            }
        }
        return newm;
    }
    
    public static void printMatrix(int[][] m){
        for(int[]row : m){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static boolean isSubString(String s, String sub){
        return(s.contains(sub));

    }

    public static boolean isRotate(String s1, String s2){
        // check if s2 is rotation of s1 by calling isSubstring only once
        if(s1.length() == s2.length() && s1.length()> 0){
            String s1s1 = s1 + s1;
            return isSubString(s1s1,s2);
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        
        //System.out.println(isCharUniqueUsingList("qwertyuiopasdftghjklzxcvbnm"));
        //System.out.println(isPermutation("abcdee","caedbe"));
        //System.out.println(sort("deacfhig"));
        //System.out.println("hello".toCharArray());
        //System.out.println(replaceSpace("Mr John Smith      ".toCharArray(), 13));
        //System.out.println(compress("aabbccddeeaaa"));
        /*
        int[][] matrix = new int[5][5];
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix.length ; j++){
                matrix[i][j] = i*5 + j + 10;
            }
        }
        printMatrix(matrix);
        printMatrix(rotateMatrix(matrix));
        
        String s = "hello";
        String sub = "ell";
        System.out.println(s.indexOf('a'));
        System.out.println(s.contains('e'));

        */
        System.out.println(isRotate("waterbottle","erbottlewat"));
        System.out.println(isRotate("waterbottle","ewaterbottl"));

    }

}
