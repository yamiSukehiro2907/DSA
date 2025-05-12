package main

func main() {

}
func solve(arr []int, B int) []int {
	prefix := make([]int64, len(arr)+1)
	prefix[0] = int64(0)
	for i := 1; i <= len(arr); i++ {
		prefix[i] = prefix[i-1] + int64(arr[i - 1])
	}
	start := -1
	end := -1
	Map := make(map[int64]int)
	Map[int64(0)] = 0
	for i := 1; i < len(prefix); i++ {
		currentSum := prefix[i]
		targetSum := currentSum - int64(B)
		if idx , exists := Map[targetSum] ; exists {
			start = idx
			end = idx
		}
	}
	if start == -1 {
		return []int{}
	}
	var ans []int
	for i := start; i <= end; i++ {
		ans = append(ans, arr[i])
	}
	return ans
}
