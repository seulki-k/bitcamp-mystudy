package bitcamp.myapp.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NcpObjectStorageService implements StorageService {

  private AmazonS3 s3;

  @Value("${ncp.storage.bucketname}")
  private String bucketName;

  public NcpObjectStorageService(@Value("${ncp.storage.endpoint}") String endPoint,
      @Value("${ncp.storage.regionname}") String regionName,
      @Value("${ncp.accesskey}") String accessKey,
      @Value("${ncp.secretkey}") String secretKey) {

    this.s3 = AmazonS3ClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
        .withCredentials(
            new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
        .build();
  }

  @Override
  public void upload(String filePath, InputStream in, Map<String, Object> options) throws Exception {
    // Object Storage에 업로드할 콘텐트의 부가 정보를 설정
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setContentType((String)options.get(CONTENT_TYPE)); // 콘텐트의 MIME TYPE 정보를 설정

    //Object Storage에 업로드할 콘텐트의 요청 정보를 준비한다.
    PutObjectRequest putObjectRequest = new PutObjectRequest(
        bucketName, //업로드 할 버킷 이름
        filePath,
        in,
        objectMetadata
    ).withCannedAcl(CannedAccessControlList.PublicRead);
    s3.putObject(putObjectRequest);
  }

  @Transactional
  @Override
  public void delete(String filePath) throws Exception {
    s3.deleteObject(bucketName, filePath);
  }

  @Override
  public void download(String filePath,OutputStream out) throws Exception {
    S3Object s3Object = s3.getObject(bucketName, filePath);
    S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();

    byte[] buf = new byte[4096]; //NCP ObjectStorage에서 값을 읽을 때 사용할 버퍼
    int len = -1;
    while ((len = s3ObjectInputStream.read(buf)) != -1) {
      out.write(buf, 0, len);
    }

    s3ObjectInputStream.close();
  }
}

