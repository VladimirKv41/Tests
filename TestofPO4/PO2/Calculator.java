package PO2;

public interface Calculator {

/**

* ��������� ����� ���� �����

*/

double sum(double a, double b);

/**

* ��������� �������� ���� ����� a - b

*/

double subtract(double a, double b);

/**

* ��������� ������������ ���� �����

*/

double multiply(double a, double b);

/**

* ��������� ��������� ����� � � ����� b.

* ������ ��������� {@link java.lang.ArithmeticException} ���� |b| < 10e-8

*/

double divide(double a, double b);

}