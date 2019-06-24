package com.demo;

public class TrickyStarPattern1 {

	public static void main(String[] args) {
		int i,j =0;
		int n=5;
		for(i = 1; i <= n; i++)
		   {
		      //outer gap loop
		      for(j = n-1; j >= i; j--)
		      {
		         System.out.print(" ");
		      }
		      System.out.print("*");
		      //inner loop
		      for(j = 1; j < (i-1) * 2; j++)
		      {
		         System.out.print(" ");
		      }
		      if(i > 1)
		      {
		         System.out.print("*");
		      }
		      System.out.print("\n");
		      }
		   }

	}


