//package testing;
//
//import java.util.*;
//
//public class GlobalMembers
//{
//	public static char[][] mm = new char[31][31];
//	public static int n;
//	public static int m;
//
//	public static void BFS(int ii,int jj,int jx,int jy)
//	{
//		LinkedList<node> q = new LinkedList<node>();
//		while (!q.isEmpty())
//		{
//			q.poll();
//		}
//		node t = new node();
//		node f = new node();
//		t.x = ii;
//		t.y = jj;
//		q.offer(t);
//		while (!q.isEmpty())
//		{
//			t = q.peek();
//			q.poll();
//			f.x = t.x + jx;
//			f.y = t.y + jy;
//			if (mm[f.x][f.y] == 'x')
//			{
//				mm[f.x][f.y] = '&';
//				break;
//			}
//			else if (mm[f.x][f.y] == '/')
//			{
//				if (jx == 0 && jy == 1)
//				{
//					jx = -1;
//					jy = 0;
//				}
//				else if (jx == 0 && jy == -1)
//				{
//					jx = 1;
//					jy = 0;
//				}
//				else if (jx == 1 && jy == 0)
//				{
//					jx = 0;
//					jy = -1;
//				}
//				else if (jx == -1 && jy == 0)
//				{
//					jx = 0;
//					jy = 1;
//				}
//			}
//			else if (mm[f.x][f.y] == '\\')
//			{
//				if (jx == 0 && jy == 1)
//				{
//					jx = 1;
//					jy = 0;
//				}
//				else if (jx == 0 && jy == -1)
//				{
//					jx = -1;
//					jy = 0;
//				}
//				else if (jx == 1 && jy == 0)
//				{
//					jx = 0;
//					jy = 1;
//				}
//				else if (jx == -1 && jy == 0)
//				{
//					jx = 0;
//					jy = -1;
//				}
//			}
//			q.offer(f);
//		}
//
//	}
//
//	public static void main(String[] args)
//	{
//		int kk = 0;
//		while (scanf("%d%d",m,n) != EOF)
//		{
//			if (n == 0 && m == 0)
//			{
//				break;
//			}
//			int xx;
//			int yy;
//			for (int i = 0; i < n; i++)
//			{
//				String tempVar = ConsoleInput.scanfRead();
//				if (tempVar != null)
//				{
//					mm[i] = tempVar.charAt(0);
//				}
//				for (int j = 0; j < m; j++)
//				{
//					if (mm[i][j] == '*')
//					{
//						xx = i;
//						yy = j;
//						break;
//					}
//				}
//			}
//			if (xx == 0)
//			{
//				BFS(xx, yy, 1, 0);
//			}
//			else if (xx == n - 1)
//			{
//				BFS(xx, yy, -1, 0);
//			}
//			else if (yy == 0)
//			{
//				BFS(xx, yy, 0, 1);
//			}
//			else if (yy == m - 1)
//			{
//				BFS(xx, yy, 0, -1);
//			}
//			System.out.printf("HOUSE %d\n",++kk);
//			for (int i = 0; i < n; i++)
//			{
//				System.out.printf("%s\n",mm[i]);
//			}
//		}
//	}


//}