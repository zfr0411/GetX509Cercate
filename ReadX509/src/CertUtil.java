import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Scanner;
 
/**
 * @author Zhoufr
 * �����һ��X.509֤���ļ���ȡ����
 */
public class CertUtil {
	/**
	 * @author Zhoufr
	 * @cerPath Java��ȡ.X.509֤����Ϣ
	 * @throws Exception 
	 * @return X509Cer��������
	 */
	public static X509Certificate getX509CerCate(String cerPath) throws Exception {
		X509Certificate x509Certificate = null;
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream fileInputStream = new FileInputStream(cerPath);
		x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
		fileInputStream.close();
		System.out.println("��ȡCer��Crt֤����Ϣ...");
		System.out.println("x509Certificate_SerialNumber_���к�___:"+x509Certificate.getSerialNumber());
		System.out.println("x509Certificate_getIssuerDN_��������ʶ��___:"+x509Certificate.getIssuerDN()); 
		System.out.println("x509Certificate_getSubjectDN_�����ʶ___:"+x509Certificate.getSubjectDN());
		System.out.println("x509Certificate_getSigAlgOID_֤���㷨OID�ַ���___:"+x509Certificate.getSigAlgOID());
		System.out.println("x509Certificate_getNotBefore_֤����Ч��___:"+x509Certificate.getNotAfter());
		System.out.println("x509Certificate_getSigAlgName_ǩ���㷨___:"+x509Certificate.getSigAlgName());
		System.out.println("x509Certificate_getVersion_�汾��___:"+x509Certificate.getVersion());
		System.out.println("x509Certificate_getPublicKey_��Կ___:"+x509Certificate.getPublicKey());
		return x509Certificate;
	}
	public static void main(String[] args) throws Exception {
		getX509CerCate("X509\\1.crt");
		getX509CerCate("X509\\2.der");
		getX509CerCate("X509\\3.cer");
		Scanner input = new Scanner(System.in);
		System.out.print("Please input the Certificate you want ");
		String path;
		path = input.next();
		getX509CerCate(path);
	}		
}
