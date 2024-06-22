import 'package:flutter/material.dart';

class MyAppBar extends StatelessWidget implements PreferredSizeWidget {
  const MyAppBar({ super.key });

  @override
  Widget build(BuildContext context){

    return AppBar(
      backgroundColor: Colors.transparent,
      elevation: 0,
      titleSpacing: 0,
      title: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              "Catálogo",
              style: TextStyle(
                  color: Colors.green, fontWeight: FontWeight.bold),
            ),
            Expanded(child: _navBarItems())
          ],
        ),
      ),
      actions: const [
        Padding(
          padding: EdgeInsets.only(right: 16.0),
          child: CircleAvatar(child: _ProfileIcon()),
        )
      ],
    );
  }


  Widget _navBarItems() => Row(
        mainAxisAlignment: MainAxisAlignment.end,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: _menuItems
            .map(
              (item) => InkWell(
                onTap: () {},
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                      vertical: 24.0, horizontal: 16),
                  child: Text(
                    item,
                    style: const TextStyle(fontSize: 18),
                  ),
                ),
              ),
            )
            .toList(),
      );

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);
}

final List<String> _menuItems = <String>[
  'Nosotros',
  'Contactanos',
  'Salir',
];

enum Menu { itemOne, itemTwo, itemThree }

class _ProfileIcon extends StatelessWidget {
  const _ProfileIcon();

  @override
  Widget build(BuildContext context) {
    return PopupMenuButton<Menu>(
      icon: const Icon(Icons.person),
      offset: const Offset(0, 40),
      onSelected: (Menu item) {},
      itemBuilder: (BuildContext context) => <PopupMenuEntry<Menu>>[
        const PopupMenuItem<Menu>(
          value: Menu.itemOne,
          child: Text('Perfil'),
        ),  
        const PopupMenuItem<Menu>(
          value: Menu.itemTwo,
          child: Text('Opciones'),
        ),
        const PopupMenuItem<Menu>(
          value: Menu.itemThree,
          child: Text('Salir'),
        ),
      ]
    );
  }
}