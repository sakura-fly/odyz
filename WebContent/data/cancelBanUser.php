<?php
/**���տͻ����ύ��uname��pid���������Ϣ��������Ҫ�ı����أ�{"msg": "ok","uid":1,"cid":100,"pid":10,"count":4}**/
header('Content-Type: text/text;charset=UTF-8');

//���տͻ����ύ������
$mname = $_REQUEST['mname'];
$uname = $_REQUEST['uname'];
//�������ݿ�
if( !$mname || !$uname){ //���ͻ���δ�ύ���������
	echo "{}";
	return;	//�˳���ǰPHPҳ���ִ��
}
$conn = mysqli_connect('localhost', 'root', '', 'OldDeal');
//SQL1�����ñ��뷽ʽ
$sql = "SET NAMES UTF8";
mysqli_query($conn, $sql);
//SQL2������uname��ѯuid
$sql = "update olddeal_user set memberLevel= 2 where uname='$uname'";
$result = mysqli_query($conn,$sql);
if($result){
   echo "succ";
}else{
echo "err";
}