package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101400685203";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDWo+yBIHVbJBBeDG0kRpRUIC7y/IVulQZ3Efvi+WAhYh/QhLpG5f5vPR7vgDjFOGsVyPFCalyZd9OKgXV5m/lsqUVUmzLtDDVKWjfDXkic8yeVC3/daUwTnoW+zHS5gABEVwhYy/Rl/VgilsErN9YDPo0yZDN/NkWt4NaWrG6isGaQoXP9uT111k8AaZT2z1SRoyTUqtcBR+hZwQTFQAL6NuVKg9hqka58t7FQMpBJr5kgkTC08rYOAF0kKavzniPwyUvoD1XeORF2uNwuAKkIwg20xryfdwZwmYpo/6yr+p7v5alFdye4NvvI8N0KcFl3eTYtexwaXVsYfWp/eFQpAgMBAAECggEBAM1Q7NDwHZJbQxTTyisjIIwAZSimCXUoNJD9sPcDGMOWO1yZOh7LrsD1tHvhKWzudPDX0IB5ga6EAuTAxYDYhJU+rkUqWGKMhQVkm2bU75zCs6BM6bkAGnfB8an7pcQz/w1gO2nFXzmYSBB+KLWQqbVcxm/njaMoZSrYoixrMUGIvp1hrSv0qHMZ4QEFhJslYLTca6DIUqmLA6Z+TBhB5UT6PkqZJzaB3XY5LxIUCibvfdBIBo7zCGSeX4VeN2MSsu/q3Z4OPfsC+VcWBc5/G5k8GILvQ9j45ZhWwY1A3l7C6AUa/IxBaQaJZiXIMyEaOiFh8qh3+PGsBheRyMrQGyECgYEA+YhaWPsgTTWhkLsp6zyU4L46QAeF1jLgXe3RinJGvCg78Z+hE82MVyqRxZ37HtcfJXcLWF7F320G0CuZC0T+lktH/radQ3lzaD5ZJku21T5gKPrkNaoS4b7WZcejKBOo9pJI4SY+ns+MMp1IQdwC8pfjY1YjxrGWuESdr183aa0CgYEA3DQPju2mOY1aDwHqmGLGOdzH8xCB8I3cUXc9MblO9dsBym2TvkTTzJW0T18P43tUP581VnuXM8CYT87dTEkUmNVATQjB34X77jEVS7Vl202OfLzLFY5w4b43PWjTlrQAHyH0jkTQgzEqVoG9O5RMkqzuoAX5HpnQ2qj6/+pnW+0CgYEAvTfISvEi7WlduoIyp06pFkMpqKQLuQGbYZ6U5ocBXGymB/MkEgAsC20cXN4PLrOxypca40f6hBIIuJJW21TWOOGdFmkjl6bg/ItKzt9bJRjHkkuuAYOWDdjIeyWHczx1Q4Rp/1Eg6ww3I6pgwJA1LABBTXJkbqb7w39Ek1eAjYECgYANMPk1oLrye6tHdt/s3Q3u7XD0+KowFO972d7KmcVHKSWEUOgm38yoVteEYbd78ylq3ki9s42tRf5Z2ZScO0yGk0/UzY9/qnEbJcmWzXkamBzPEChCVFQi0dhRT3RNdN8E/m2+EBVFpq5YnFEPvqSPrNhmsbToxmIilzjiF9K1SQKBgGbIY1K0XcM+Y3T2eEnjJyWcpktnUYE3FObNVo7Lp3O1uZSBjNTzZq5O/uPPp+TAMsRSMCrEksPR3jyiOTUvACT+/Mzd2UXOyswrFoHresAq8XEbEaQoR0wKvn9YCjDPDBkE2CDV5g58jEt0qd+uKo2+SCmhdAXJqiOM+xmvvFzz";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlGQHZitIS5C52lOgl/WkLCJXVqHSaiRp1hm2uxAzcPlyLRsPKq0ZliZzYR7ul0PWuJZtR8qfwcgupsohbRYyhBIhUJguXQi0tvdP3qS8MgGW9lNqI0YPxywB4urerGKVvi9O/pZ4aL2J3tzBkaBgQSUZNapZZkE7HTcp0sUWk9klsYIPcQfgYiGNnKX2cdn6Kv4qQQdTv68x+UZC7vJ8u/a22j8DcwddBcIIjk6UswG493jxxMSWk9L+o9y3R4N7ByVnyUe84rNvBnPyy9AN/CntSmxyTw8Ef4K1Piu/9eYdtGRoI+zu0R1q3SgaiIJZx4eMxvory4BNjuUyy0EI6wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8989/dangdang/order/updateOrderByOrderId";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

