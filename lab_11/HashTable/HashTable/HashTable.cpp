#include <iostream>
#include <string>
#include <Windows.h>

using namespace std;

/*
Пример ввода:

add 123422 item1
add 132421 item2
add 203948 item3
add 232444 item4
find 123422
find 132421
find 123456
find 232444
end
--------------------
Пример вывода :

item1
item2
The product is not in the HashTable
item4
*/


struct Hash_element {
	string name;
	long id;
	Hash_element* child = 0;

	Hash_element(long id1, string name1) {
		name = name1;
		id = id1;
	}

	void deleting() {
		if (child != 0)child->deleting();
		delete this;
	}

};

struct Hash_table {
	Hash_element** table;
	int size;
	int x;

	Hash_table(int size1, int x1) {
		size = size1;
		x = x1;
		table = new Hash_element * [size];
		for (int i = 0; i < size; i++) {
			table[i] = 0;
		}
	}

	void insert(Hash_element* el) {
		int hash = get_hash(el->id);
		if (table[hash] == 0)table[hash] = el;
		else {
			Hash_element* parent = table[hash];
			while (parent->child != 0)parent = parent->child;
			parent->child = el;
		}
	}

	int get_hash(long id) {
		int hash = 0;
		for (int i = 0; id > 0; i++) {
			hash += (int)((id % 10) * pow(x, 6 - i - 1)) % size;
			id /= 10;
		}
		return hash % size;
	}

	void deleting() {
		for (int i = 0; i < size; i++) {
			if (table[i] != 0) {
				table[i]->deleting();
			}
		}
		delete[] table;
		delete this;
	}
};


int main()
{
	setlocale(LC_ALL, "Russian");
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	int size = 15;
	Hash_table* t = new Hash_table(size, 10);
	string command, name;
	long id;
	while (true) {
		cin >> command;
		if (command == "add") {
			cin >> id >> name;
			Hash_element* el = new Hash_element(id, name);
			t->insert(el);
		}
		else if (command == "find") {
			cin >> id;
			Hash_element* element = t->table[t->get_hash(id)];
			if (element == 0) cout << "The product is not in the HashTable" << endl;
			else {
				while (element != 0) {
					if (element->id == id) cout << element->name << endl;
					element = element->child;
				}
			}
		}
		else if (command == "end") break;
	}
	t->deleting();
}


