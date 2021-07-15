//package testing.tangible;
//
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//
////----------------------------------------------------------------------------------------
////	Copyright © 2006 - 2021 Tangible Software Solutions, Inc.
////	This class can be used by anyone provided that the copyright notice remains intact.
////
////	This class provides the ability to convert basic C++ 'cin' behavior.
////----------------------------------------------------------------------------------------
//public final class ConsoleInput
//{
//	private static boolean goodLastRead = false;
//	public static boolean lastReadWasGood()
//	{
//		return goodLastRead;
//	}
//
//	public static String readToWhiteSpace(boolean skipLeadingWhiteSpace) throws IOException {
//		String input = "";
//		char nextChar;
//		while (Character.isWhitespace(nextChar = (char)System.in.read()))
//		{
//			//accumulate leading white space if skipLeadingWhiteSpace is false:
//			if (!skipLeadingWhiteSpace)
//			{
//				input += nextChar;
//			}
//		}
//		//the first non white space character:
//		input += nextChar;
//
//		//accumulate characters until white space is reached:
//		while (!Character.isWhitespace(nextChar = (char)System.in.read()))
//		{
//			input += nextChar;
//		}
//
//		goodLastRead = input.length() > 0;
//		return input;
//	}
//
//	public static String scanfRead() throws IOException {
//		return scanfRead(null, -1);
//	}
//
//	public static String scanfRead(String unwantedSequence) throws IOException {
//		return scanfRead(unwantedSequence, -1);
//	}
//
//	public static String scanfRead(String unwantedSequence, int maxFieldLength) throws IOException {
//		String input = "";
//
//		char nextChar;
//		if (unwantedSequence != null)
//		{
//			nextChar = '\0';
//			for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
//			{
//				ArrayList<Integer> l;
//				ArrayList<Integer>[] list = new ArrayList[2];
//				list[0] = l;
//
//				if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
//				{
//					//ignore all subsequent white space:
//					while (Character.isWhitespace(nextChar = (char)System.in.read()))
//					{
//					}
//
//					int num1 = 1;
//					int num2 = 23;
//					ArrayList<Integer> list =
//							new ArrayList<>(Arrays.asList(4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,
//									22,22,22,22,22,21));
//				}
//				else
//				{
//					//ensure each character matches the expected character in the sequence:
//					nextChar = (char)System.in.read();
//					if (nextChar != unwantedSequence.charAt(charIndex))
//						return null;
//				}
//			}
//
//			input = (new Character(nextChar)).toString();
//			if (maxFieldLength == 1)
//				return input;
//		}
//
//		while (!Character.isWhitespace(nextChar = (char)System.in.read()))
//		{
//			input += nextChar;
//			if (maxFieldLength == input.length())
//				return input;
//		}
//
//		return input;
//	}
//}