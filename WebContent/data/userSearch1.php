<?php
header('Content-Type:application/json');
@$mname=$_REQUEST['mname'];
@$pageNum=$_REQUEST['pageNum'];
@$kw = $_REQUEST['kw'];
if( !$mname || !$pageNum || !$kw){ //���ͻ���δ�ύ���������
	echo "{}";
	return;	//�˳���ǰPHPҳ���ִ��
}
$pager=[
'recordCount'=>0,
'pageSize'=>8,
'pageCount'=>0,
'pageNum'=>intval($pageNum),
'data'=>null
];
$conn=mysqli_connect('localhost','root','','OldDeal');
$sql="set names utf8";
mysqli_query($conn,$sql);
//sql2 ��ȡ�ܼ�¼�� ������ҳ��
$sql="select count(*) from olddeal_user where uname LIKE '%$kw%' AND memberLevel =1";
$result=mysqli_query($conn,$sql);
$row=mysqli_fetch_assoc($result);
$pager['recordCount']=intval($row['count(*)']);//���ַ�������Ϊ����
$pager['pageCount']=ceil(($pager['recordCount'])/($pager["pageSize"]));
//var_dump($pager['pageCount']);
//sql3 ��ȡ��ǰָ��ҳ�е�����
$count=$pager['pageSize'];
$start=($pager['pageNum']-1)*$count;
$sql="select *from olddeal_user where uname LIKE '%$kw%' AND memberLevel =1 limit $start,$count";
$result=mysqli_query($conn,$sql);
$pager['data']=mysqli_fetch_all($result,MYSQLI_ASSOC);
$str=json_encode($pager);
echo $str;