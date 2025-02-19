import pytest

def test_calculate_sum():
    a = 10
    b = 25
    assert a+b == 35

def test_calculate_difference():
    a = 30
    b = 10
    assert a-b == 20

@pytest.mark.activity
def test_calculate_product():
    a = 2
    b = 3
    assert a*b == 6

@pytest.mark.activity
def test_calculate_quotient():
    a = 10
    b = 2
    assert a/b == 5