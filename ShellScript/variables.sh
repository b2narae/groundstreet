# no space permitted on either side of = sign
PRICE_PER_APPLE=5
MyFirstLetter=ABC
greeting='Hello World!'

# \ : used to escape special character
# " " : Encapsulating the variable name with "" will preserve any whitespace values
greeting='Hello       world!'
echo $greeting" now with spaces: $greeting"

#substitution : Variables can be assigned with the value of a command output
#way to substitution : $() or ` `
FILELIST=`ls`
FileWithTimeStamp=/tmp/my-dir/file_$(/bin/date +%Y-%m-%d).txt
