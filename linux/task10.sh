#!/bin/bash

read -p "enter the name:" name

length=${#name}

	for i in $(seq 1 $length)
	do
		string_index=$((i-1))
 
		#echo "character $((i+1)):${string_index:i:1}"
        echo "character is ${name:string_index:1}"

	done

