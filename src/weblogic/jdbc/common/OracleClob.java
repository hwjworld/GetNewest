package weblogic.jdbc.common;

import java.io.OutputStream;
import java.io.Writer;
import java.sql.SQLException;

/**
 * д����ӿڵ�Ŀ����Ϊ���ڷ�Weblogicƽ̨�ϲ��÷�weblogic.jar��
 * (enp.EnpArticleContent.java�Ὣһ��clob���ͳɴ˽ӿڣ����û�б��뼰���г���)��
 * ����weblogicƽ̨�ϻ����weblogic.jar����ͬ�Ľӿڣ���Ϊweblogic.jar��classpath�Ľ�ǰ��
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public interface OracleClob
{

    public abstract OutputStream getAsciiOutputStream()
        throws SQLException;

    public abstract Writer getCharacterOutputStream()
        throws SQLException;
}
