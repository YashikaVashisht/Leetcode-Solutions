class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        final=[]
        for i in range(numRows):
            l1 = [1] * (i + 1)  
            final.append(l1)
        for i in range(2,numRows):
            for j in range(1,i):
                final[i][j]=final[i-1][j-1]+final[i-1][j]
        return final        
                    





        
        