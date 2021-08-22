#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <set>

using namespace std;

vector<string> split(string str, char delimiter);

int main() {
	string input;
	cin >> input; 
	set<string> s;

	for (int i = 0; i < input.length(); i++) {
		string temp = "";

		for (int j = i; j < input.length(); j++) {
			temp += input[j];
		
			s.insert(temp);
		}
	}

	cout << s.size();
	

	return 0;
}

vector<string> split(string input, char delimiter){
	vector<string> data;
	stringstream ss(input);
	string temp;

	while (getline(ss, temp, delimiter)) {
		data.push_back(temp);
	}

	return data;
}
