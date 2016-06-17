package VoteApp;

/**
* VoteApp/VoteHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Vote.idl
* 2016��1��1�� ������ ����01ʱ14��17�� CST
*/

public final class VoteHolder implements org.omg.CORBA.portable.Streamable
{
  public VoteApp.Vote value = null;

  public VoteHolder ()
  {
  }

  public VoteHolder (VoteApp.Vote initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = VoteApp.VoteHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    VoteApp.VoteHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return VoteApp.VoteHelper.type ();
  }

}
