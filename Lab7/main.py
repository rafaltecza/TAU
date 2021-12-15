from unittest import TestCase

import requests


class FakeApiTestCase(TestCase):

    def setUp(self):
        self.api = f"https://fakestoreapi.com/"

    def test_get_products_200(self):
        api = f"{self.api}/products/1"
        response = requests.get(api)
        expected_response = {
            "id": 1,
            "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            "price": 109.95,
            "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            "category":"men's clothing",
            "image":"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            "rating": {
                "rate": 3.9,
                "count": 120
            }
        }
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_get_categories_returns_none(self):
        api = f"{self.api}/products/9542"
        response = requests.get(api)
        expected_response = None
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_get_products_returns_list_object_with_no_specified_id(self):
        api = f"{self.api}/products"
        response = requests.get(api)
        self.assertEqual(response.status_code, 200)
        self.assertIsInstance(response.json(), list)
        self.assertEqual(len(response.json()), 20)

    def test_post_carts_returns_200_with_response(self):
        api = f"{self.api}/carts"
        example_request = {
                    'userId': 5,
                    'date': '2020-02-03',
                    'products': [{'productId': 5,'quantity': 1},{'productId': 1,'quantity': 5}]
        }
        expected_response = {
                    'date': '2020-02-03',
                    'id': 11,
                    'products': ['productId', 'quantity', 'productId', 'quantity'],
                    'userId': '5'
        }
        response = requests.post(api, data=example_request)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_get_cart_of_user_returns_content(self):
        api = f"{self.api}/carts/user/1"
        expected_response = [
            {
                '__v': 0,
                'date': '2020-03-02T00:00:02.000Z',
                'id': 1,
                'products': [{'productId': 1, 'quantity': 4},
                               {'productId': 2, 'quantity': 1},
                               {'productId': 3, 'quantity': 6}],
                'userId': 1},
            {
                '__v': 0,
                'date': '2020-01-02T00:00:02.000Z',
                'id': 2,
                'products':
                    [
                        {'productId': 2, 'quantity': 4},
                        {'productId': 1, 'quantity': 10},
                        {'productId': 5, 'quantity': 2}
                    ],
                'userId': 1
            }
        ]
        response = requests.get(api)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_put_products_returns_success(self):
        api = f"{self.api}/products/7"
        expected_response = {
            'category': 'electronic',
            'description': 'lorem ipsum set',
            'id': '7',
            'image': 'https://i.pravatar.cc',
            'price': '13.5',
            'title': 'test product'
        }
        response = requests.put(api, data=expected_response)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_patch_products_returns_success_partial_mod(self):
        api = f"{self.api}/products/7"

        request_body = {
            'title': 'test product',
            'price': 13.5,
            'description': 'lorem ipsum set',
            'image': 'https://i.pravatar.cc',
            'category': 'electronic'
        }
        expected_response = {
            'category': 'electronic',
            'description': 'lorem ipsum set',
            'id': '7',
            'image': 'https://i.pravatar.cc',
            'price': '13.5',
            'title': 'test product'
        }
        response = requests.patch(api, data=request_body)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_delete_posts_returns_success(self):
        api = f"{self.api}/products/6"
        response = requests.delete(api)

        # Note from API
        # The product will not be deleted on the database.
        # but if you sent data successfully it will return you the fake deleted product.
        expected_response = {
            'category': 'jewelery',
            'description': 'Satisfaction Guaranteed. Return or exchange any order within '
                            '30 days.Designed and sold by Hafeez Center in the United '
                            'States. Satisfaction Guaranteed. Return or exchange any order '
                            'within 30 days.',
            'id': 6,
            'image': 'https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg',
            'price': 168,
            'rating': {'count': 70, 'rate': 3.9},
            'title': 'Solid Gold Petite Micropave '
        }

        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), expected_response)

    def test_delete_posts_returns_not_found(self):
        api = f"{self.api}/products"
        request_body = {"id": 12323}
        response = requests.delete(api, data=request_body)
        self.assertEqual(response.status_code, 404)
