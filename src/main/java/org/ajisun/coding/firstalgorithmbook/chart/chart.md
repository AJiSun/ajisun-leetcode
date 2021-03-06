### 一， 图的搜索

分为 “广度优先搜索” 和 “深度优先搜索”

#### 广度优先搜索
> 广度优先搜索是一种对图进行搜索的算法。假设我们一开始位于某个顶点（即起点），此
时并不知道图的整体结构，而我们的目的是从起点开始顺着边搜索，直到到达指定顶点（即终
点）。在此过程中每走到一个顶点，就会判断一次它是否为终点。广度优先搜索会优先从离起点
近的顶点开始搜索。

广度优先搜索的特征为从起点开始，由近及远进行广泛的搜索。因此，目标顶点离
起点越近，搜索结束得就越快。

#### 深度优先搜索
> 深度优先搜索和广度优先搜索一样，都是对图进行搜索的算法，目的也都是从起点开始搜
  索直到到达指定顶点（终点）。深度优先搜索会沿着一条路径不断往下搜索直到不能再继续为
  止，然后再折返，开始搜索下一条候补路径。
  
  
  
  深度优先搜索的特征为沿着一条路径不断往下，进行深度搜索。虽然广度优先搜索
  和深度优先搜索在搜索顺序上有很大的差异，但是在操作步骤上却只有一点不同，那就
  是选择哪一个候补顶点作为下一个顶点的基准不同。
  广度优先搜索选择的是最早成为候补的顶点，因为顶点离起点越近就越早成为候
  补，所以会从离起点近的地方开始按顺序搜索；而深度优先搜索选择的则是最新成为候
  补的顶点，所以会一路往下，沿着新发现的路径不断深入搜索。