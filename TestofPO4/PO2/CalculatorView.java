package PO2;

public interface CalculatorView {

/**

* ���������� ��������� ����������

*/

void printResult(double result);

/**

* ���������� ������, �������� ������� �� 0, ������ ��������� � ������

*/

void displayError(String message);

/**

* ���������� ��������, ��������� � ���� ������� ���������

*/

String getFirstArgumentAsString();

/**

* ���������� ��������, ��������� � ���� ������� ���������

*/

String getSecondArgumentAsString();

}
