class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
       
        num=n^(n>>1)
        if(num&(num+1)==0):
            return True
        else:
            return False    

                


