package VoteApp;


/**
* VoteApp/VoteOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Vote.idl
* 2016��1��1�� ������ ����01ʱ14��17�� CST
*/

public interface VoteOperations 
{
  String getList ();
  void castVote (String candidate);
} // interface VoteOperations
