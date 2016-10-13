/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author tomas
 */
public class BST {

    private BST_node root;

    public void add(BST_node paNode) {

        if (root == null) {
            root = paNode;
        }

        BST_node actual = root;
        while (true) {

            if (actual.getData().compare(paNode.getData().getKey()) == -1) {
                if (actual.getLeft() == null) {
                    actual.setLeft(paNode);
                    break;
                } else {
                    actual = actual.getLeft();
                }

            } else if (actual.getData().compare(paNode.getData().getKey()) == 1) {
                if (actual.getRight() == null) {
                    actual.setRight(paNode);
                    break;
                } else {
                    actual = actual.getRight();
                }
            } else {
                break;
            }
        }
    }

    public void delete(Object paKey) {
        BST_node actual = root;
        BST_node rodic = null;

        while (actual!=null) {
            //ak 0 deti
            if (actual.getData().compare(paKey) == 0) {
                if (actual.getPocetDeti() == 0) {
                    if (rodic.getLeft() == actual) {
                        rodic.setLeft(null);
                        break;
                    } else {
                        rodic.setRight(null);
                        break;
                    }
                    //ak jedno dieta  
                } else if (actual.getPocetDeti() == 1) {
                    if (rodic.getLeft() == actual) {
                        if (actual.getLeft() == null) {
                            rodic.setLeft(actual.getRight());
                            break;
                        } else {
                            rodic.setLeft(actual.getLeft());
                            break;
                        }
                    } else if (actual.getLeft() == null) {
                        rodic.setRight(actual.getRight());
                        break;
                    } else {
                        rodic.setRight(actual.getLeft());
                        break;
                    }
                    //ak 2 deti
                } else {

                    BST_node min = actual.getRight();
                    BST_node rodicMin = actual;
                    //Najdenie minima v Lavom podstrome
                    while (min.getLeft() != null) {
                        rodicMin = min;
                        min = min.getLeft();
                    }
                    //System.out.println(min.getData().toString());
                    if (rodicMin.getLeft() == min) {
                        rodicMin.setLeft(null);
                    } else {
                        rodicMin.setRight(null);
                    }

                    if (actual == root) {
                        root.setLeft(actual.getLeft());
                        root.setRight(actual.getRight());
                        root.setData(min.getData());
                    } else {
                        min.setLeft(actual.getLeft());
                        min.setRight(actual.getRight());
                        if (rodic.getLeft() == actual) {
                            rodic.setLeft(min);
                        } else {
                            rodic.setRight(min);
                        }
                    }

                    break;
                }
                //pokracovanie v hladani
            } else if (actual.getData().compare(paKey) == -1) {
                rodic = actual;
                actual = actual.getLeft();
            } else {
                rodic = actual;
                actual = actual.getRight();
            }
            
        }
    }

    public BST_node search(Object paKey) {
        BST_node actual = root;

        while (true) {
            if (actual.getData().compare(paKey) == 0) {
                return (BST_node) actual;
            }

            if (actual.getData().compare(paKey) == -1) {
                actual = actual.getLeft();
            } else if (actual.getData().compare(paKey) == 1) {
                actual = actual.getRight();
            }

            if (actual == null) {
                System.out.println("Nenasiel sa vrchol s klucom:" + paKey.toString());
                return null;
            }
        }

    }

    /**
     * Preorder
     *
     * @param koren
     */
    private void vypisStrom(BST_node koren) {
        if (koren == null) {
            return;
        }
        // vypisStrom(koren.getLeft());
        System.out.println(koren.getData().toString());
        vypisStrom(koren.getLeft());
        vypisStrom(koren.getRight());
    }

    public void vypis() {
        vypisStrom(root);
    }

    public BST_node getRoot() {
        return root;
    }

}
