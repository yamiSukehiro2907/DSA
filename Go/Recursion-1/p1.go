package main

import "fmt"

func main() {
	// arr := solve(2)
	// for i := 0; i < len(arr); i++ {
	// 	fmt.Println(arr[i])
	// }
	Map := make(map[int64]int)
	Map[0] = 1;
	sum := 0
	sum += 1
	sum += 1000000000
	fmt.Println(sum)
}


// "0" "1"
// func solve(n int) []string {
// 	if n == 1 {
// 		arr := make([]string, 2)
// 		arr[0] = "0"
// 		arr[1] = "1"
// 		return arr
// 	}
// 	prev := solve(n - 1)
// 	ans := make([]string, len(prev)*2)
// 	k := 0
// 	for i := 0; i < len(prev); i++ {
// 		ans[k] = "0" + prev[i]
// 		k++
// 	}
// 	for i := len(prev) - 1; i >= 0; i-- {
// 		ans[k] = "1" + prev[i]
// 		k++
// 	}
// 	return ans
// }
