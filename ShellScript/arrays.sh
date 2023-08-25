my_array=(apple banana "Fruit Basket" orange)
new_array[2]=apricot

echo ${#my_array[@]}
echo ${my_array[0]}

# adding element to array
my_array[4]="new inserted one"
echo ${#my_array[@]}
echo ${my_array[${#my_array[@]}-1]}
