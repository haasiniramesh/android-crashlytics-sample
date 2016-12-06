# ********************************************************
#
#                   AWS S3 File upload
#
# ************** Steps to setup AWSCLI *******************
# curl "https://s3.amazonaws.com/aws-cli/awscli-bundle.zip" -o "awscli-bundle.zip"
# unzip awscli-bundle.zip
# sudo ./awscli-bundle/install -i /usr/local/aws -b /usr/local/bin/aws
# ********************************************************
# 
# ************** Configure AWS CLI ***********************
# aws configure
# AWS Access Key ID [None]: your-access-key-id
# AWS Secret Access Key [None]: your-secret-access-key
# Default region name [None]: region-to-use (e.g us-west-2, us-west-1, etc).
# Default output format [None]: json
# ********************************************************

S3_KEY="my aws key"
S3_SECRET="my aws secret"

function put_s3
{
  path=$1
  permission="uri=http://acs.amazonaws.com/groups/global/AllUsers"
  bucket="s3://si-android-apps/"
  echo "Uploading $path to bucket $bucket"

  #AWS CLI
  aws s3 cp $path $bucket --grants read=$permission
}

put_s3 "bsa.json"