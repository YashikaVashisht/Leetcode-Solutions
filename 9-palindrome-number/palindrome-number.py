class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bo
        ol
        """
        rev = 0
        n = x
        if(x>0):
            while(x!=0):
                rev = (rev*10) +  x % 10
                x = x // 10
    
        if(rev==n):
                return True
        else:
            return False 
        