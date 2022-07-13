import time


def ingress_frame_high_contract(browser):
    time.sleep(3)
    framedata = None
    for unit_frame in browser.find_elements_by_tag_name('iframe'):
        if 'Interface' in unit_frame.get_attribute('name'):
            framedata = unit_frame
            StopIteration
    browser.switch_to.frame(framedata)