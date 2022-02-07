# Leaf
 世界上没有两片完全相同的树叶。

# 构建上传
> 修改 gradle.properties  版本、执行以下命令上传到maven私有仓库
```
version=0.0.1
```
- 上传文件
```
# gradle publish 
```

# 快速开始
- 添加依赖

``` 
# maven
<dependency>
  <groupId>com.fumanix.framework</groupId>
  <artifactId>leaf-spring-boot-starter</artifactId>
  <version>0.0.1</version>
</dependency>
```

``` 
# gradle
implementation 'com.fumanix.framework:leaf-spring-boot-starter:0.0.1'
```


- 使用案例

> 测试案例

```java
public class LeafGeneratorTest {
    @Test
    public void strGenerator(){
        //OS + 20200617102056 + 自增序列(截取字符串0到16位为key自增, 取4位数字(不足位前面补0))
        LeafGenerator.gen("str@OS|date@yyyyMMddHHmmss|seq@4,0,16");      //OS202006162224490001
        //以 ESA 为Key 生成8位数字自增序列(不足8位前面补0)
        LeafGenerator.gen("seq@8,ESA");                                  //00000001 - 99999999
        //SN + 20200617102056 + 随机字符(截取字符串0到16位为key比对随机生成的6位字符串是否已存在)
        SnGenerator.gen("str@SN|date@yyyyMMddHHmmss|random@6,0,16");
        //32位交易号
        LeafGenerator.gen("trade@");
        //或
        LeafGenerator.gen("trade@32");
        //28位交易号
        LeafGenerator.gen("trade@28");
    }
}

```
