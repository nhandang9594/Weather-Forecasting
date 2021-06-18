#include <iostream>
#include <string>

using namespace std;

int main()
{

	string username;
	string password;
	string userlog;
	string passlog;

	cout<<"--------------create an account---------------"<<endl;

	cout<<"Create a username"<<endl;
	getline(cin, username);

	cout<<"Create a password"<<endl;
	getline(cin, password);

	cout<<"-------------login----------------"<<endl;

	cout<<"Enter your username"<<endl;
	cin>>userlog;
	cout<<"Enter your password"<<endl;
	cin>>passlog;

	if(userlog == username)
	{
		if(passlog == password)
		{
			cout<<"login successful"<<endl;
		}
		else
		{
			cout<<"Incorrect username or password"<<endl;
		}
	}
	else
	{
		cout<<"Incorrect username or password"<<endl;
	}

return 0;

}
